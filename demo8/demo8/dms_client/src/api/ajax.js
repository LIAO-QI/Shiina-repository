import axios from 'axios'

export default function ajax(url, data = {}, type = 'GET') {
    return new Promise(function (resolve, reject) {
        let promise;
        if(type === 'GET'){
            promise = axios.get(url, { params: data })
        }else if (type === 'POST') {
            promise = axios.post(url, data)
        }
        promise.then((response)=> {
            resolve(response)
        }).catch((error) => {
            reject(error)
        })
    })
}