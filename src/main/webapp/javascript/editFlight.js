async function updateFlight(flight) {
  const hasEmptyAttribute = Object.values(flight).some((value) => {
    return value === null || value === undefined || value === "";
  });

  if (hasEmptyAttribute) {
    Swal.fire({
      title: "Saving failed!",
      text: "Please complete the whole table",
      icon: "error",
    });
    return;
  }
  flight.departureTime = Math.floor(new Date(flight.departureTime).getTime() / 1000);
  flight.arrivalTime = Math.floor(new Date(flight.arrivalTime).getTime() / 1000);
  fetch("/api/flights/update", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(flight),
  })
    .then((response) => {
      if (response.status == 200) {
        Swal.fire({
          title: "Saved!",
          text: "Changes have been saved.",
          icon: "success",
        }).then(() => {
          window.location.href = "FlightManagement.html";
        });
      } else {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Changes are not saved",
        });
      }
    })
    .catch((error) => {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Changes are not saved",
      });
    });
}

$(document).ready(function () {
  flatpickr(".datepicker", {
    enableTime: true,
    dateFormat: "Y-m-d H:i",
  });

  const arrivalPickr = flatpickr(".arrival-container .datepicker", {
    enableTime: true,
    dateFormat: "Y-m-d H:i",
  });

  if (arrivalPickr.calendarContainer) {
    $(arrivalPickr.calendarContainer).css("margin-right", "300px");
  }
  const flightData = JSON.parse(localStorage.getItem("currentFlight"));
  const urlParams = new URLSearchParams(window.location.search);

  if (urlParams.get("mode") == "edit") {
    {
      $("#flightNumber").val(flightData.flightNumber);
      $("#airlineName").val(flightData.airlineName);
      $("#aircraftCode").val(flightData.aircraftCode);
      $("#originName").val(flightData.originName);
      $("#destinationName").val(flightData.destinationName);
      const departureTime = flatpickr.formatDate(
        new Date(flightData.departureTime * 1000),
        "Y-m-d H:i"
      );
      const arrivalTime = flatpickr.formatDate(
        new Date(flightData.arrivalTime * 1000),
        "Y-m-d H:i"
      );
      $("#departureTime").val(departureTime);
      $("#arrivalTime").val(arrivalTime);
    }
  }

  if (urlParams.get("mode") == "add") {
  }

  $("#save-btn").click(function () {
    const flight = {
      id: flightData.id,
      flightNumber: $("#flightNumber").val(),
      airlineName: $("#airlineName").val(),
      aircraftCode: $("#aircraftCode").val(),
      originName: $("#originName").val(),
      destinationName: $("#destinationName").val(),
      departureTime: $("#departureTime").val(),
      arrivalTime: $("#arrivalTime").val(),
    };
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#d33",
      cancelButtonColor: "#3085d6",
      confirmButtonText: "Yes, save it!",
    }).then((result) => {
      if (result.isConfirmed) {
        updateFlight(flight);
      } else {
        return;
      }
    });
  });
});
