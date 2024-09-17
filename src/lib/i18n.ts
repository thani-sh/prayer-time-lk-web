const values: { [lang: string]: { [key: string]: string } } = {
	en: {
		fajr: 'Fajr',
		sunrise: 'Sunrise',
		dhuhr: 'Dhuhr',
		asr: 'Asr',
		asr_hanafi: 'Asr (حَنَفِية)',
		maghrib: 'Maghrib',
		isha: 'Isha'
	}
};

/**
 * Returns the translation of the given key.
 */
export function t(key: string, lang: keyof typeof values = 'en'): string {
	return values[lang][key];
}

/**
 * A collection of useful formatting functions.
 */
export const f = {
	time(hour: number, minute: number): string {
		const h = String(hour > 12 ? hour - 12 : hour);
		const m = minute.toString().padStart(2, '0');
		const a = hour > 12 ? 'pm' : 'am';
		return `${h}:${m} ${a}`;
	}
};
