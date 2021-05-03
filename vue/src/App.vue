<template>
  <div id="app">
  <!--  <Lyrics v-bind:lyrics="lyrics" /> -->
    <div id="nav">
      <router-link to="/">Random Difficulty</router-link> |
      <router-link to="/level1">Difficulty Level 1</router-link> |
      <router-link to="/level2">Difficulty Level 2</router-link> |
      <router-link to="/level3">Difficulty Level 3</router-link> 
    </div>
    <router-view />
    
  <!--  <flashcard :front="lyrics" :back="answer"></flashcard> -->
  </div>
</template>

<script>
//import flashcard from './components/Flashcard.vue'
//import Lyrics from './components/Lyrics';
import LyricService from './services/LyricService'

export default {
  name: 'app',
  components: {
 //   Lyrics
  //  flashcard,
  },
  created() {
    LyricService.getLyrics().then(response => {
   //   this.lyrics = response.data;
      this.$store.commit('setLyrics', response.data)
    })
  },
 /* data() {
    return {
      lyrics: [
        {
          id: 1,
          lyric: "Sample Lyrics 1",
          answer: "Sample Answer 1"
        },
        {
          id: 2,
          lyric: "Sample Lyrics 2",
          answer: "Sample Answer 2"
        },
        {
          id: 3,
          lyric: "Sample Lyrics 3",
          answer: "Sample Answer 3"
        }
      ]
     // lyrics: 'Sample lyrics',
     // answer: 'Sample answer',
    }
  },*/
}
</script>

<style>

#app {
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap');
  font-family: 'Quicksand', sans-serif;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #13161a;
 /* background-image: url("~@/assets/musicnotes.jpg");
  background-size: auto;
  background-position: center;
  background-repeat: no-repeat;*/
}

#nav {
  padding: 30px;
}

#nav a {
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap');
  font-family: 'Quicksand', sans-serif;
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: red;
}

#nav a:hover {
  color: blue;
}

.button {
  text-align: center;
  margin-top: 25px;
}

button {
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap');
  font-family: 'Quicksand', sans-serif;
  text-transform: uppercase;
  color:red;
  background-color: black;
  /*cursor: url("~@/assets/singlemusicnote.jpg");*/
}

html {
  background: url("~@/assets/musicnotes.jpg");
  background-position: center;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

</style>
