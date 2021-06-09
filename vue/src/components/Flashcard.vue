<template>
    <div>
        <div @click="isToggle=!isToggle" v-bind:style="{backgroundColor: colorFront, color: colorTextFront}" v-show="!isToggle" class="animated flipInX flashcard">
            <div class="card-header" style="padding-bottom: 15px;"> {{headerFront}}</div>
            <div class="card-content center">
                <p v-bind:style="{fontSizeFront, fontWeight: 'bold'}">{{front}}</p>
                <img v-if="imgFront!=''" :src="imgFront" width="200" height="200">
            </div>
            <div class="card-footer" style="margin: 100px;">{{footerFront}}</div>
        </div>
        <div @click="isToggle=!isToggle" v-bind:style="{backgroundColor: colorBack, color: colorTextBack}" v-show="isToggle" class="animated flipInX flashcard">
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
export default {
    data() {
        return {
            isToggle: false,
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
    }
}
</script>

<style>
.center {
    text-align: center;
}
.flashcard {
    cursor:pointer;
    text-align: center;
    background-color: limegreen;
    background-image: linear-gradient(red, white, blue);
    border: 1px black;
    border-style: solid;
    border-radius: 10px;
    box-shadow: 0 0px rgba(0, 0, 0, 0.4);
    margin: auto;
    height: 300px;
    width: 400px;
}
.flashcard:hover {
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