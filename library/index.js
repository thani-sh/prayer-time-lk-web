import colombo from "./times/colombo.js";

/**
 * Reutrns prayer times for a given month and day
 * @param {number} month
 * @param {number} day
 * @returns {PrayerTimes}
 */
export function forMonthAndDay(month, day) {
  const times = colombo.find((t) => t.m === month && t.d === day).t;
  return {
    fajr: times[0],
    sunrise: times[1],
    dhuhr: times[2],
    asr: times[3],
    maghrib: times[4],
    isha: times[5],
  };
}

/**
 * Reutrns prayer times for a given date
 * @param {Date} date
 * @returns {PrayerTimes}
 */
export function forDate(date) {
  const m = date.getMonth() + 1;
  const d = date.getDate();
  return forMonthAndDay(m, d);
}

/**
 * Returns prayer times for today
 * @returns {PrayerTimes}
 */
export function forToday() {
  return forDate(new Date());
}
