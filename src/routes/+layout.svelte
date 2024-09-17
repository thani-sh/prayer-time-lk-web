<script>
	import './styles.css';
</script>

<div class="wrapper">
	<slot />
</div>

<style>
	.wrapper {
		display: flex;
		height: 100vh;
		align-items: center;
		justify-content: center;
		overflow: hidden;
	}
</style>
