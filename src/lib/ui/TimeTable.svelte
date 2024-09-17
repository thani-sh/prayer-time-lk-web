<script lang="ts">
	import type { PrayerTimes } from '@thani-sh/prayer-time-lk';
	import { t, f } from '$lib/i18n';

	// Prayer times to display in a table
	export let prayerTimes: PrayerTimes;

	// Convert the prayer times to an array of objects to use with table rows
	$: rows = Object.entries(prayerTimes).map(([name, { hour, minute }]) => {
		return {
			name: t(name),
			time: f.time(hour, minute)
		};
	});
</script>

<div class="timetable">
	{#each rows as entry}
		<div class="row">
			<div class="col name">{entry.name}</div>
			<div class="col time">{entry.time}</div>
		</div>
	{/each}
</div>

<style>
	.timetable {
		display: flex;
		flex-direction: column;
		font-size: 24px;
	}

	.row {
		display: flex;
		box-sizing: border-box;
		padding: 10px 0;
	}

	.row + .row {
		border-top: 1px dashed #222;
	}

	.col {
		display: flex;
		width: 150px;
		box-sizing: border-box;
		padding: 0 10px;
	}

	.col + .col {
		border-left: 1px dashed #222;
	}

	.name {
		justify-content: flex-end;
	}

	.time {
		justify-content: flex-start;
	}
</style>
