<script lang="ts">
	import { date } from '$lib/store';
	import TimeTable from '$lib/ui/TimeTable.svelte';
	import { forDate } from '@thani-sh/prayer-time-lk';

	$: prayers = forDate($date);
</script>

<div class="content">
	<h1>Prayer Time</h1>
	<TimeTable {prayers} />
</div>

<style>
	.content {
		display: flex;
		margin-top: -100px;
		flex-direction: column;
		font-size: 24px;
		pointer-events: none;
	}

	.content h1 {
		display: block;
		text-align: center;
	}
</style>
