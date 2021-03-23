<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/Level1">Difficulty Level 1</router-link> |
      <router-link to="/level2">Difficulty Level 2</router-link> |
      <router-link to="/level3">Difficulty Level 3</router-link> 
    </div>
    <router-view />
    
    <flashcard :front="lyrics" :back="answer"></flashcard>
  </div>
</template>

<script>
//import flashcard from './components/Flashcard.vue'
export default {
  components: {
  //  flashcard,
  },
  data() {
    return {
      lyrics: 'Sample lyrics',
      answer: 'Sample answer',
    }
  },
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
