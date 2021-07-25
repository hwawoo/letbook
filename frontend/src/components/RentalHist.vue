<template>

<v-data-table
    :headers="headers"
    :items="rentalHist"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'RentalHist',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "renterName", value: "renterName" },
            { text: "bookTitle", value: "bookTitle" },
            { text: "cardNo", value: "cardNo" },
            { text: "rentalResult", value: "rentalResult" },
            { text: "rentFee", value: "rentFee" },
        ],
        rentalHist : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/rentalhists')

      this.rentalHist = temp.data._embedded.rentalhists;

    },
    methods: {
    }
  }
</script>

