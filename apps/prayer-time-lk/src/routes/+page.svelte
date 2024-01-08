<script lang="ts">
	import { date } from '$lib/store';
	import TimeTable from '$lib/ui/TimeTable.svelte';
	import Datepicker from '$lib/ui/DatePicker.svelte';
	import { forDate } from '@thani-sh/prayer-time-lk';

	// Prayer times for the selected date
	$: prayerTimes = forDate($date);
</script>

<div class="content">
	<h1>Prayer Time</h1>
	<TimeTable {prayerTimes} />
</div>
<div class="overlay">
	<Datepicker />
</div>

<style>
	.content {
		display: flex;
		margin-top: -100px;
		flex-direction: column;
		font-size: 24px;
	}

	.content h1 {
		display: block;
		text-align: center;
	}

	.overlay {
		position: absolute;
		display: flex;
		box-sizing: border-box;
		padding: 50px;
		align-items: flex-end;
		justify-content: center;
		width: 100%;
		height: 100vh;
		top: 0;
		left: 0;
	}
</style>
