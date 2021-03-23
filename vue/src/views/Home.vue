<template>
    <div class="home">
        <h1>Welcome to the best lyrics app!</h1>
        <h2>Guess the Song and Artist</h2>
 <!--   <img src="../assets/musicnotes.jpg" alt="Musical Notes"> -->
  <!--  <lyric/> -->
        <div @click="isToggle=!isToggle" v-bind:style="{backgroundColor: colorFront, color: colorTextFront}" v-show="!isToggle" class="animated flipInX flashcardhome">
            <div class="card-header" style="padding-bottom: 15px;"> {{headerFront}}</div>
            <div class="card-content center">
                <p v-bind:style="{fontSizeFront, fontWeight: 'bold'}">{{front}}</p>
                <img v-if="imgFront!=''" :src="imgFront" width="200" height="200">
            </div>
            <div class="card-footer" style="margin: 75px;">{{footerFront}}</div>
        </div>
        <div @click="isToggle=!isToggle" v-bind:style="{backgroundColor: colorBack, color: colorTextBack}" v-show="isToggle" class="animated flipInX flashcardhome">
            <div class="card-header" style="padding-bottom: 15px;"> {{headerBack}}</div>
            <div class="card-content center">
                <p v-bind:style="{fontSize: textSizeBack, fontWeight: 'bold'}">{{back}}</p>
                <img v-if="imgBack!=''" :src="imgBack" width="200" height="200">
            </div>
            <div class="card-footer">{{footerBack}}</div>
        </div>
    </div>
</template>

<script>

//import Lyric from './Lyric.vue'
import LyricService from '../services/LyricService'
export default {
  name: 'home',
  data() {
    return {
      isToggle: false,
      lyrics: []
    }
  },
  props: {
    imgFront: {
        type: String,
        default: ''
    },
    imgBack: {
        type: String,
        default: ''
    },
    front: {
        type: String,
        default: 'default front'
    },
    back: {
        type: String,
        default: 'default back'
    },
    textSizeFront: {
        type: String,
        default: '2em'
    },
    textSizeBack: {
        type: String,
        default: '2em'
    },
    colorTextFront: {
        type: String,
        default: 'black'
    },
    colorTextBack: {
        type: String,
        default: 'green'
    },
    colorFront: {
        type: String,
        default: 'white'
    },
    colorBack: {
        type: String,
        default: '#2ecc71'
    },
    headerFront: {
        type: String,
        default: 'How well do you know these lyrics?'
    },
    headerBack: {
        type: String,
        default: 'Answer'
    },
    footerFront: {
        type: String,
        default: 'Click once to reveal the answer'
    },
    footerBack: {
        type: String,
        default: 'Click the Next Lyric button to continue'
    }
  },
  mounted() {
    console.log('Component mounted')
  },
  created() {
    LyricService.getLyrics().then(response => {
      this.lyrics = response.data;
    })
  },
  methods: {
    viewLyrics(id) {
      this.$router.push(`/lyric/${id}`);
    }

  },
  components: {

   // Lyric
  }
}
</script>

<style>
.home h1 {
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap');
  font-family: 'Quicksand', sans-serif;
  font-size: 55px;
  background: -webkit-linear-gradient(yellow, red);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  text-align: center;
  text-transform: uppercase;
  text-rendering: optimizeLegibility;
  color: #131313;
  margin-top: 1px;
  letter-spacing: .15em;
  /*text-shadow: 
      1px -1px 0 #767676, 
      -1px 2px 1px #737272, 
      -2px 4px 1px #767474, 
      -3px 6px 1px #787777, 
      -4px 8px 1px #7b7a7a, 
      -5px 10px 1px #7f7d7d, 
      -6px 12px 1px #828181, 
      -7px 14px 1px #868585, 
      -8px 16px 1px #8b8a89, 
      -9px 18px 1px #8f8e8d, 
      -10px 20px 1px #949392, 
      -11px 22px 1px #999897, 
      -12px 24px 1px #9e9c9c, 
      -13px 26px 1px #a3a1a1, 
      -14px 28px 1px #a8a6a6, 
      -15px 30px 1px #adabab, 
      -16px 32px 1px #b2b1b0, 
      -17px 34px 1px #b7b6b5, 
      -18px 36px 1px #bcbbba, 
      -19px 38px 1px #c1bfbf, 
      -20px 40px 1px #c6c4c4, 
      -21px 42px 1px #cbc9c8, 
      -22px 44px 1px #cfcdcd, 
      -23px 46px 1px #d4d2d1, 
      -24px 48px 1px #d8d6d5, 
      -25px 50px 1px #dbdad9, 
      -26px 52px 1px #dfdddc, 
      -27px 54px 1px #e2e0df, 
      -28px 56px 1px #e4e3e2;*/
}
.home h2 {
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap');
  font-family: 'Quicksand', sans-serif;
  background-color:rgb(153, 153, 153);
  background-image: radial-gradient(white, gray, black);
  opacity: 90%;
}
.center {
    text-align: center;
}
.flashcardhome {
    cursor:pointer;
    text-align: center;
    background-color: gray;
    background-image: radial-gradient(white, gray, black); /*or linear-gradient*/
    border: 1px black;
    border-style: solid;
    border-radius: 10px;
    box-shadow: 0 0px rgba(0, 0, 0, 0.4);
    margin: auto;
    height: 300px;
    width: 400px;
}
.flashcardhome:hover {
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
