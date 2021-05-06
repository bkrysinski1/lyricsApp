<template>
  <div>
    <div class="level1">
      <h1>Welcome to Difficulty Level 1</h1>
    </div>
    <div @click="isToggle = !isToggle" v-bind:style="{ backgroundColor: colorFront, color: colorTextFront }" v-show="!isToggle" class="animated flipInX flashcard1">
      <div class="card-header" style="padding-bottom: 15px">{{ headerFront }}</div>
      <div class="card-content center">
        <p v-bind:style="{ fontWeight: 'bold' }"><pre style="font-family:Quicksand;">{{ randomLevel1Lyric }}</pre></p>
        <p>{{ randomLyricSong.genre }}</p>
        <p>{{ randomLevel1.year_released }}</p>
        <img v-if="imgFront != ''" :src="imgFront" width="200" height="200" />
      </div>
      <div class="card-footer" style="margin: 60px">{{ footerFront }}</div>
    </div>
    <div @click="isToggle = !isToggle" v-bind:style="{ backgroundColor: colorBack, color: colorTextBack }" v-show="isToggle" class="animated flipInX flashcard1">
      <div class="card-header" style="padding-bottom: 15px">
        {{ headerBack }}
      </div>
      <div class="card-content center">
        <p v-bind:style="{ fontSize: textSizeBack, fontWeight: 'bold' }">
          {{ randomLyricArtist.artist_name }}
        </p>
        <p v-bind:style="{ fontSize: textSizeBack }">
          {{ randomLyricSong.title }}
        </p>
        <img v-if="imgBack != ''" :src="imgBack" width="200" height="200" />
      </div>
      <div class="card-footer">{{ footerBack }}</div>
    </div>
    <button v-on:click="getNextRandomLyric">Next Lyric</button>
  </div>
</template>

<script>
import LyricService from "../services/LyricService";
import ArtistService from "../services/ArtistService";
import SongService from "../services/SongService";

export default {
  name: "level1",
  components: {
    
  },

  data() {
    return {
      isToggle: false,
      randomLevel1: {
        lyrics: "",
      },
      randomLyricArtist: {},
      randomLyricSong: {},
    };
  },
  props: {
    imgFront: {
      type: String,
      default: "",
    },
    imgBack: {
      type: String,
      default: "",
    },
    front: {
      type: String,
      default: "default front",
    },
    back: {
      type: String,
      default: "default back",
    },
    textSizeFront: {
      type: String,
      default: "2em",
    },
    textSizeBack: {
      type: String,
      default: "2em",
    },
    colorTextFront: {
      type: String,
      default: "black",
    },
    colorTextBack: {
      type: String,
      default: "white",
    },
    colorFront: {
      type: String,
      default: "white",
    },
    colorBack: {
      type: String,
      default: "#2ecc71",
    },
    headerFront: {
      type: String,
      default: "How well do you know these lyrics?",
    },
    headerBack: {
      type: String,
      default: "Answer",
    },
    footerFront: {
      type: String,
      default: "Click once to reveal the answer",
    },
    footerBack: {
      type: String,
      default: "Click the Next Lyric button to continue",
    },
  },
  computed: {
      randomLevel1Lyric() {
        if (!this.randomLevel1.lyric) {
          return "";
        }  else {
            return this.randomLevel1.lyric.replace(/\\n/g,'\n');
          }
      }
  },
  created() {
    LyricService.getRandomLyric().then((response) => {
      this.randomLevel1 = response.data;

      SongService.getSongById(this.randomLevel1.song_id).then((response) => {
        this.randomLyricSong = response.data;

        ArtistService.getArtistById(this.randomLyricSong.artist_id).then(
          (response) => {
            this.randomLyricArtist = response.data;
          });
      });
    });
  },
  methods: {
    getNextRandomLyric() {
      LyricService.getRandomLyric(1).then((response) => {
        this.randomLevel1 = response.data;

        SongService.getSongById(this.randomLevel1.song_id).then((response) => {
          this.randomLyricSong = response.data;

          ArtistService.getArtistById(this.randomLyricSong.artist_id).then((response) => {
              this.randomLyricArtist = response.data;
              this.isToggle = false;
          });
        });
      });
    },
    viewLyrics(id) {
      this.$router.push(`/lyric/${id}`);
    },
  },
};
</script>

<style>
.level1 h1 {
  @import url("https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap");
  font-family: "Quicksand", sans-serif;
  text-align: center;
  width: 100%;
  /*margin: 5px;*/
  color: purple;
  background-color: rgb(7, 12, 12);
  background-image: radial-gradient(aqua, blue, purple);
  opacity: 90%;
}

.center {
  text-align: center;
}
.flashcard1 {
  cursor: pointer;
  text-align: center;
  background-color: blue;
  background-image: radial-gradient(aqua, blue, purple);
  border: 1px black;
  border-style: solid;
  border-radius: 10px;
  box-shadow: 0 0px rgba(0, 0, 0, 0.4);
  margin: auto;
  height: 300px;
  width: 400px;
}
.flashcard1:hover {
  box-shadow: 0 0px 25px rgba(0, 0, 0, 0.8);
}
.animated {
  animation-duration: 1s;
  animation-fill-mode: both;
}

@keyframes flipInX {
  from {
    transform: perspective(400px) rotate3d(1, 0, 0, 90deg);
    animation-timing-function: ease-in;
    opacity: 0;
  }
  40% {
    transform: perspective(400px) rotate3d(1, 0, 0, -20deg);
    animation-timing-function: ease-in;
  }
  60% {
    transform: perspective(400px) rotate3d(1, 0, 0, 10deg);
    opacity: 1;
  }
  80% {
    transform: perspective(400px) rotate3d(1, 0, 0, -5deg);
  }
  to {
    transform: perspective(400px);
  }
}

.flipInX {
  backface-visibility: visible !important;
  animation-name: flipInX;
}
</style>