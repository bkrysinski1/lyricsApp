import axios from 'axios';



export default {
    getLyrics() {
        return axios.get(`/lyrics`);
    },

    getLyricById(id) {
        return axios.get(`/lyrics/${id}`, id);
    },

    getRandomLyric(difficultyLevel) {
        if (difficultyLevel) { 
            return axios.get(`/lyrics/random?difficultyLevel=${difficultyLevel}`);
        } else {
            return axios.get(`/lyrics/random`);
        }
    }
}