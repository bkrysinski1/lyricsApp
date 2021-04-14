<template>
    <div>
        <div v-bind:key="lyric.id" v-for="lyric in lyrics"
            <h3>{{lyric.lyric}}</h3>
        </div>
    </div>
</template>

<script>
export default {
    name: "Lyrics",
    props: ["lyrics"]
}
</script>

<style scoped>

</style>
