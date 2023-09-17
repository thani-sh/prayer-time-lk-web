<script lang="ts">
	import { forToday } from '@thani-sh/prayer-time-lk';
	import { t } from '$lib/i18n';

	let prayers = forToday();
	let entries = Object.entries(prayers).map(([name, { hour, minute }]) => {
		const h = String(hour > 12 ? hour - 12 : hour);
		const m = minute.toString().padStart(2, '0');
		const a = hour > 12 ? 'pm' : 'am';
		return {
			name: t(name),
			time: `${h}:${m} ${a}`
		};
	});
</script>

<div class="wrapper">
	<h1>Prayer Times</h1>
	{#each entries as entry}
		<div class="row">
			<div class="col name">{entry.name}</div>
			<div class="col time">{entry.time}</div>
		</div>
	{/each}
</div>

<style>
	.wrapper {
		margin-top: -100px;
		display: flex;
		flex-direction: column;
		font-size: 24px;
	}

	.wrapper h1 {
		display: block;
		text-align: center;
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
