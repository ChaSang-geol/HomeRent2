export default {
  data () {
    return { is_script_loading: false }
  },
  created () {
    // If another component is already loading the script
    this.$root.$on('loading_script', e => { this.is_script_loading = true })
  },
  methods: {
    load_script () {
      let self = this
      return new Promise((resolve, reject) => {

        // if script is already loading via another component
        if ( self.is_script_loading ){
          // Resolve when the other component has loaded the script
          this.$root.$on('script_loaded', resolve)
          return
        }

        let script = document.createElement('script')
        script.setAttribute('src', 'https://www.google.com/recaptcha/api.js')
        script.async = true

        this.$root.$emit('loading_script')

        script.onload = () => {
          /* emit to global event bus to inform other components
           * we are already loading the script */
          this.$root.$emit('script_loaded')
          resolve()
        }

        document.head.appendChild(script)

      })

    },

    async use_script () {
      try {
        await this.load_script()
        // .. do what you want after script has loaded
      } catch (err) { console.log(err) }

    }
  }
}