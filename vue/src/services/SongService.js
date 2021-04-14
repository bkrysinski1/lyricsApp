import axios from 'axios';

export default {
    getSongById(id) {
        return axios.get(`/song/${id}`);
    }
}