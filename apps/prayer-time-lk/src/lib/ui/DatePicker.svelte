<script lang="ts">
	import { date } from '$lib/store';

	/**
	 * Convert a Date object to a string in the format YYYY-MM-DD
	 */
	function toDateString(input: Date) {
		const m = '' + (input.getMonth() + 1);
		const d = '' + input.getDate();
		const y = input.getFullYear();
		return [y, m.padStart(2, '0'), d.padStart(2, '0')].join('-');
	}

	// Date string for the input element
	let dateString = toDateString($date);

	$: {
		// Update the store when the user selects a date
		date.set(new Date(dateString));
	}
</script>

<input class="datepicker" type="date" bind:value={dateString} />

<style>
	.datepicker {
		padding: 10px 15px;
		background: none;
		border: none;
		outline: none;
		color: #888;
		box-sizing: border-box;
		color-scheme: dark;
	}

	.datepicker:focus {
		border: none;
		outline: none;
	}
</style>
