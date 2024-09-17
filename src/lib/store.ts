import { writable } from 'svelte/store';

/**
 * Holds the current date as a svelte store.
 */
export const date = writable(new Date());
