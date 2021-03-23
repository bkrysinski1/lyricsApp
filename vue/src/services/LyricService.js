import axios from 'axios';



export default {
    getLyrics() {
        return axios.get(`/lyrics`);
    },

    getLyricById(id) {
        return axios.get(`/lyrics/${id}`, id);
    },

    getRandomLyric() {
        return axios.get(`/lyrics/random`);
    }
}