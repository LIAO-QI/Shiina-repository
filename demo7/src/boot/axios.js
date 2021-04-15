import Vue from 'vue'
import axios from 'axios'

axios.interceptors.request.use(
	config => {
		let token = localStorage.getItem('Authorization');
		if (token) {
			config.headers.Authorization = 'Bearer ' + token;
		}

		return config;
	}, error => {

		return Promise.reject(error);
	})

axios.interceptors.response.use(
	config => {
		return config
	}, error => {
		if (error.response) {
			if (error.response.status === 401) {
				localStorage.removeItem('Authorization');
			}
		}
	})

Vue.prototype.$axios = axios
