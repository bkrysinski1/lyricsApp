<template>
    <div>
        <h2>Guess the Song and Artist</h2>
    </div>
</template>

<style scoped>

</style>

<script>
import LyricService from '../services/LyricService'

export default {
    name: "lyric-list",
    data() {
        return {
            lyrics: []
        }
    },
    created() {
        LyricService.getLyrics().then(response => {
            this.lyrics = response.data;
        })
    },
    methods: {
        viewLyric(id) {
            this.$router.push(`/lyrics/${id}`);
        }
    }
}
</script>