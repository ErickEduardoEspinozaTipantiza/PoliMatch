import daisyui from 'daisyui'

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  plugins: [daisyui],
  daisyui: {
    themes: ["light"], 
  },
}