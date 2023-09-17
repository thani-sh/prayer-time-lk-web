interface Time {
  hour: number;
  minute: number;
}

interface PrayerTimes {
  fajr: Time;
  sunrise: Time;
  dhuhr: Time;
  asr: Time;
  maghrib: Time;
  isha: Time;
}

function forDate(date: Date): PrayerTimes;

function forToday(): PrayerTimes;
