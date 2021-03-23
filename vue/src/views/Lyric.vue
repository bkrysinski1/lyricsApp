<template>
    <div>
        <h2>Guess the Song and Artist</h2>
    </div>
</template>

<style scoped>
/*h2 {
    background-color:rgb(153, 153, 153);
    background-image: radial-gradient(white, gray, black);
    margin-top: 50px;
}*/
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