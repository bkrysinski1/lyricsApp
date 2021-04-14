import axios from 'axios';

export default {
    getArtistById(id) {
        return axios.get(`/artist/${id}`);
    }
}