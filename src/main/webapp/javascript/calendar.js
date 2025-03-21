let departureDate = null;
let arrivalDate = null;
let hoverDate = null;

const departurePicker = flatpickr(".departure-date", {
  dateFormat: "Y-m-d",
  minDate: "today",
  onChange: function (selectedDates) {
    departureDate = selectedDates[0];
    if (arrivalDate && arrivalDate < departureDate) {
      arrivalPicker.setDate(null);
      arrivalDate = null;
    }
    arrivalPicker.set("minDate", departureDate);
    markDateRange();
  },
  onOpen: function () {
    markDateRange();
  },
});

const arrivalPicker = flatpickr(".arrival-date", {
  dateFormat: "Y-m-d",
  minDate: "today",
  onChange: function (selectedDates) {
    arrivalDate = selectedDates[0];
    markDateRange();
  },
  onOpen: function () {
    markDateRange();
  },
});

function markDateRange() {
  const departureInstance = departurePicker;
  const arrivalInstance = arrivalPicker;

  if (departureInstance.calendarContainer) {
    departureInstance.calendarContainer
      .querySelectorAll(".flatpickr-day")
      .forEach((dayElem) => {
        const date = departureInstance.parseDate(dayElem.dateObj);

        dayElem.classList.remove(
          "departure-day",
          "arrival-day",
          "range-day",
          "hover-range-day"
        );

        if (
          departureDate &&
          date.toDateString() === departureDate.toDateString()
        ) {
          dayElem.classList.add("departure-day");
        }

        if (arrivalDate && date.toDateString() === arrivalDate.toDateString()) {
          dayElem.classList.add("arrival-day");
        }

        if (
          departureDate &&
          hoverDate &&
          date > departureDate &&
          date < hoverDate
        ) {
          dayElem.classList.add("range-day");
        }
      });
  }

  if (arrivalInstance.calendarContainer) {
    arrivalInstance.calendarContainer
      .querySelectorAll(".flatpickr-day")
      .forEach((dayElem) => {
        const date = arrivalInstance.parseDate(dayElem.dateObj);

        dayElem.classList.remove(
          "departure-day",
          "arrival-day",
          "range-day",
          "hover-range-day"
        );

        if (arrivalDate && date.toDateString() === arrivalDate.toDateString()) {
          dayElem.classList.add("arrival-day");
        }

        if (
          departureDate &&
          date.toDateString() === departureDate.toDateString()
        ) {
          dayElem.classList.add("departure-day");
        }

        if (
          departureDate &&
          hoverDate &&
          date > departureDate &&
          date < hoverDate
        ) {
          dayElem.classList.add("range-day");
        }
      });
  }
}

function addHoverListener(picker) {
  if (picker.calendarContainer) {
    picker.calendarContainer.addEventListener("mouseover", (e) => {
      const dayElem = e.target.closest(".flatpickr-day");
      if (dayElem && !dayElem.classList.contains("flatpickr-disabled")) {
        hoverDate = picker.parseDate(dayElem.dateObj);
        markDateRange();
      }
    });

    picker.calendarContainer.addEventListener("mouseout", () => {
      hoverDate = null;
      markDateRange();
    });
  }
}

addHoverListener(departurePicker);
addHoverListener(arrivalPicker);

function updateTravellers() {
  const adults = $("#adults").val();
  const kids = $("#kids").val();
  const cabinClass = $("#cabinClass").val();
  $("#travellers").val(
    `${parseInt(adults) + parseInt(kids)} Travellers, ${cabinClass}`
  );
}
