/** @type {import('tailwindcss').Config} */
export default {
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  darkMode: 'class',
  content: [],
  theme: {
    extend: {},
    backgroundImage: {
      "hero-pattern": "url('/src/assets/herobg.jpg')"
    }
  },
  variants: {
    extend: {
      padding: ['hover']
    }
  },
  plugins: [],
}

