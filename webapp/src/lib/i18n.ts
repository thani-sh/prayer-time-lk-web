const values: { [lang: string]: { [key: string]: string } } = {
	en: {
		fajr: 'Fajr',
		sunrise: 'Sunrise',
		dhuhr: 'Dhuhr',
		asr: 'Asr',
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
