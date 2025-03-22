function renderFlights(flights) {
    const container = document.getElementById("flightsContainer");
    if (container != null) {
        container.innerHTML = "";
    }
    flights.forEach((flight) => {
        const params = new URLSearchParams();
        params.set("id", flight.id);
        params.set("flightNumber", flight.flightNumber);
        params.set("aircraftCode", flight.aircraftCode);
        params.set("airlineName", flight.airlineName);
        params.set("originName", flight.originName);
        params.set("destinationName", flight.destinationName);
        const departureTime = new Date(
            flight.departureTime * 1000
        ).toLocaleString();
        const arrivalTime = new Date(flight.arrivalTime * 1000).toLocaleString();
        params.set("departureTime", departureTime);
        params.set("arrivalTime", arrivalTime);
        const url = `UpdateFlight.html?${params.toString()}&mode=edit`;
        const card = `
   <div class="col-12 mb-4">
    <div class="card h-100">
        <div class="card-body">
            <h5 class="card-title">Flight Number: ${flight.flightNumber}</h5>
            <div class="grid-container">
                <div class="col-1">
                    <p><strong>Airline: </strong><span>${
            flight.airlineName
        }</span></p>
                    <p><strong>Origin: </strong><span>${
            flight.originName
        }</span></p>
                    <p><strong>Departure: </strong><span>${departureTime}</span></p>
                </div>
                <div class="col-2">
                    <p><strong>Aircraft Code: </strong><span>${
            flight.aircraftCode
        }</span></p>
                    <p><strong>Destination: </strong><span>${
            flight.destinationName
        }</span></p>
                    <p><strong>Arrival: </strong><span>${arrivalTime}</span></p>
                </div>
                <div class="col-3  d-flex align-items-center">
                    <div class="button-container">
                        <button
                            type="button"
                            class="btn btn-primary edit-btn"
                            data-flight='${JSON.stringify(flight)}'
                            onclick="handleEdit(this)"
                        >
                            Edit
                        </button>
                        <button
                            type="button"
                            class="btn btn-danger"
                            data-flight-number="${flight.flightNumber}"
                        >
                            Delete
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    `;
        container.insertAdjacentHTML("beforeend", card);
    });
}

let currentFlights = [];

async function searchFlights() {
    const originIataCode = $("#originName").data("iataCode")?.trim()?.toUpperCase() || "";
    const destinationIataCode = $("#destinationName").data("iataCode")?.trim()?.toUpperCase() || "";
    const departureTime = $("#departureTime").val()?.trim() || "";
    const arrivalTime = $("#arrivalTime").val()?.trim() || "";
    const flightNumber = $("#flightNumber").val()?.trim()?.toUpperCase() || "";

    if (
        !originIataCode &&
        !destinationIataCode &&
        !departureTime &&
        !arrivalTime &&
        !flightNumber
    ) {
        Swal.fire({
            title: "No values given!",
            text: "Please enter at least one value in the search bar",
            icon: "error",
        });
        return;
    }

    const params = new URLSearchParams();
    if (flightNumber) params.append("flightNumber", flightNumber);
    if (originIataCode) params.append("originIataCode", originIataCode);
    if (destinationIataCode) params.append("destinationIataCode", destinationIataCode);
    if (departureTime)
        params.append("departureTime", new Date(departureTime).getTime());
    if (arrivalTime)
        params.append("arrivalTime", new Date(arrivalTime).getTime());
    const url = `api/flights/search?${params.toString()}`;


    try {
        const response = await fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (response.status === 200) {
            const resultSet = await response.json();
            currentFlights = resultSet;
            if (resultSet.length > 0) {
                renderFlights(resultSet);
                return 200;
            } else {
                if (resultSet.length == 0) {
                    Swal.fire({
                        title: "No flight found",
                        text: "Please enter other values",
                        icon: "error",
                    });
                    return 404;
                }
            }
        } else {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Something went wrong! Please try again.",
            });
            return response.status();
        }
    } catch (error) {
        Swal.fire({
            icon: "error",
            title: "Network Error",
            text: "There was an error connecting to the server. Please check your connection.",
        });
        return 500;
    }
}

function deleteFlight(flightNumber) {
    const url = `api/flights/delete?flightNumber=${flightNumber}`;

    fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then((response) => {
            if (response.status === 200) {
                Swal.fire({
                    title: "Deleted!",
                    text: "The flight has been deleted",
                    icon: "success",
                }).then(() => {
                    currentFlights = currentFlights.filter(
                        (flight) => flight.flightNumber !== flightNumber
                    );
                    if (currentFlights.length == 0) {
                        Swal.fire({
                            icon: "error",
                            title: "No flights found",
                            text: "No other flights match the criteria. Please enter other values",
                        }).then(() => {
                            location.reload();
                        });
                    } else {
                        renderFlights(currentFlights);
                    }
                });
            } else {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Something went wrong! Please try again",
                    footer: '<a href="#">Why do I have this issue?</a>',
                });
            }
        })
        .catch((error) => {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Something went wrong! Please try again",
                footer: '<a href="#">Why do I have this issue?</a>',
            });
        });
}

function handleEdit(button) {
    const flightData = JSON.parse(button.getAttribute("data-flight"));
    localStorage.setItem("currentFlight", JSON.stringify(flightData));
    window.location.href = "UpdateFlight.html?mode=edit";
}

$(document).ready(function () {
    let cache = {};

    function setupAutocomplete(inputId, suggestionListId) {
        let debounceTimer;
        let $input = $("#" + inputId);
        let $suggestions = $("#" + suggestionListId);

        $input.on("input", function () {
            clearTimeout(debounceTimer);
            let query = $(this).val().trim();

            if (query.length < 2) {
                $suggestions.empty().hide();
                return;
            }

            debounceTimer = setTimeout(function () {
                if (cache[query]) {
                    showSuggestions(cache[query], $input, $suggestions);
                } else {
                    $.getJSON(
                        "/api/airport?query=" + query,
                        function (data) {
                            cache[query] = data;
                            showSuggestions(data, $input, $suggestions);
                        }
                    );
                }
            }, 300);
        });

        function showSuggestions(data, $input, $suggestions) {
            $suggestions.empty();
            if (data.length === 0) {
                $suggestions.hide();
                return;
            }

            data.forEach(function (item) {
                let li = $("<li>")
                    .addClass("list-group-item data-iataCode")
                    .text(item.airportName + " (" + item.iataCode + ")")
                    .on("click", function () {
                        $input.val(item.airportName + " (" + item.iataCode + ")");
                        $input.data("iataCode", item.iataCode);
                        $suggestions.hide();
                    })
                    .on("mouseenter", function () {
                        $(this).addClass("active");
                    })
                    .on("mouseleave", function () {
                        $(this).removeClass("active");
                    });

                $suggestions.append(li);
            });

            $suggestions.show();
        }

        $input.on("keydown", function (e) {
            if (e.key === "Enter") {
                selectFirstOption($input, $suggestions);
                e.preventDefault();
            }
        });

        $input.on("blur", function () {
            setTimeout(function () {
                if (!$(document.activeElement).hasClass("list-group-item")) {
                    selectFirstOption($input, $suggestions);
                }
            }, 200);
        });

        $input.on("focus", function () {
            if ($suggestions.find(".list-group-item").length > 0) {
                $suggestions.show();
            }
        });
    }

    function selectFirstOption($input, $suggestions) {
        let $firstOption = $suggestions.find(".list-group-item:visible").first();
        if ($firstOption.length) {
            $input.val($firstOption.text());
            $input.data("iataCode", $firstOption.data("iataCode"));
            $suggestions.hide();
        }
    }

    setupAutocomplete("originName", "originSuggestions");
    setupAutocomplete("destinationName", "destinationSuggestions");

    $(document).on("click", ".list-group-item", function () {
        let $parentList = $(this).closest(".list-group");
        let $input = $parentList.siblings("input");
        const text = $(this).text().trim();
        const airportName = text.replace(/ \(.*\)$/, "");
        const iataCode = text.match(/\(([^)]+)\)/)[1];

        $input.val(airportName + " (" + iataCode + ")");
        $input.data("iataCode", iataCode);
        $parentList.hide();
    });
});

$("#search-btn").click(async function () {
    const resultsCode = await searchFlights();
    if (resultsCode == 200) {
        $("#search-bar").css({
            height: "10vh",
            transition: "height 0.5s ease",
        });
        $("#flightsContainer").css("display", "flex");
    }
});

$(document).on("click", ".edit-btn", function () {
    const flightData = $(this).data("flight");
    localStorage.setItem("currentFlight", JSON.stringify(flightData));
    window.location.href = "UpdateFlight.html?mode=edit";
});

$(document).on("click", ".btn-danger", function () {
    const flightNumber = $(this).data("flight-number");
    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#3085d6",
        confirmButtonText: "Yes, delete it!",
    }).then((result) => {
        if (result.isConfirmed) {
            deleteFlight(flightNumber);
        } else {
            return;
        }
    });
});

$("#switch").click(function () {
    rotation = 180;
    $(this)
        .find("i")
        .animate(
            {rotate: rotation},
            {
                duration: 300,
                step: function (now) {
                    $(this).css("transform", `rotate(${now}deg)`);
                },
            }
        );

    const departureValue = $("#originName").val();
    const arrivalValue = $("#destinationName").val();

    $("#originName").val(arrivalValue);
    $("#destinationName").val(departureValue);
});

$("#applyButton").click(function () {
    let adults = $("#adults").val();
    let kids = $("#kids").val();
    let cabinClass = $("#cabinClass").val();

    $("#passengerInput").val(`${adults} Adults, ${kids} Kids, ${cabinClass}`);

    let dropdownInstance = bootstrap.Dropdown.getOrCreateInstance(
        $("#passengerInput")[0]
    );
    if (dropdownInstance) {
        dropdownInstance.hide();
    }
});

$("#adultsPlus").click(function (event) {
    event.stopPropagation();
    $("#adults").val(function (_, val) {
        let adultsValue = parseInt(val);
        return isNaN(adultsValue) ? 1 : adultsValue + 1;
    });
});

$("#adultsMinus").click(function (event) {
    event.stopPropagation();
    $("#adults").val(function (_, val) {
        let adultsValue = parseInt(val);
        return isNaN(adultsValue) ? 1 : Math.max(1, adultsValue - 1);
    });
});

$("#kidsPlus").click(function (event) {
    event.stopPropagation();
    $("#kids").val(function (_, val) {
        let kidsValue = parseInt(val);
        return isNaN(kidsValue) ? 0 : kidsValue + 1;
    });
});

$("#kidsMinus").click(function (event) {
    event.stopPropagation();
    $("#kids").val(function (_, val) {
        let kidsValue = parseInt(val);
        return isNaN(kidsValue) ? 0 : Math.max(0, kidsValue - 1);
    });
});

$(
    "#cabinClass,#adultsPlus, #adultsMinus, #kidsPlus, #kidsMinus, #applyButton"
).click(function () {
    updateTravellers();
});