import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    mutations: {
        setUnanswered (state, lyrics) {
            state.unansweredLyrics = lyrics
        },
        pushAnswered (state, lyrics) {
            state.unansweredLyrics = state.unansweredLyrics.filter((lyr) => lyr !== lyrics)
                state.unansweredLyrics.push(lyrics)
        },
        setCurrentLyrics (state, lyrics) {
            state.currentLyrics = lyrics
            state.cardFlipped = false
        },
        flipCard (state) {
            state.cardFlipped = !state.cardFlipped
        },
    },
    state: {
        unansweredLyrics: [],
        currentLyrics: {
            lyrics: 'Sample lyrics',
            answer: 'Sample answer'
        },
        cardFlipped: false,
    },

    getters: {
        currentLyrics (state) {
            return state.currentLyrics.lyrics
        },
        currentAnswer (state) {
            return state.currentAnswer.answer
        },
    },

    

    actions: {
        init (context) {
            context.commit('setCurrentLyrics', getRandomLyric(context))
        },
        answeredLyric (context) {
            const lyric = context.state.currentLyrics
            context.commit('pushAnswered', lyric)
            context.commit('setCurrentLyric', getRandomLyric(context))
        },
    },
})

function getRandomLyric (context) {
    const numLyrics = context.state.unansweredLyrics.length

    if (numLyrics > 0) {
        const randomIndex = Math.floor(numLyrics * Math.random())
        return context.state.unansweredLyrics[randomIndex]
    } else {
        return null
    }
}