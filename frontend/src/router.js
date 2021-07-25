
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BookRentManager from "./components/BookRentManager"


import RentalHist from "./components/RentalHist"
import BookStoreManager from "./components/BookStoreManager"

import PaymentManager from "./components/PaymentManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/bookRents',
                name: 'BookRentManager',
                component: BookRentManager
            },


            {
                path: '/rentalHists',
                name: 'RentalHist',
                component: RentalHist
            },
            {
                path: '/bookStores',
                name: 'BookStoreManager',
                component: BookStoreManager
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },



    ]
})
