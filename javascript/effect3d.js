let el = document.querySelectorAll('.card-centent>main>a')
const sound = document.querySelector("#hover-sound")

el.forEach(element => {
  const height = element.clientHeight
  const width = element.clientWidth

  function handleMove(e) {
    const xVal = e.layerX
    const yVal = e.layerY
    const yRotation = 20 * ((xVal - width / 2) / width)
    const xRotation = -20 * ((yVal - height / 2) / height)
    const string = 'perspective(500px) rotateX(' + xRotation + 'deg) rotateY(' + yRotation + 'deg)'

    element.style.transform = string
  }

  element.addEventListener('mousemove', handleMove)

  element.addEventListener('mouseout', function () {
    element.style.transform = 'perspective(500px) scale(1) rotateX(0) rotateY(0)'
  })
  if (sound) {
    element.addEventListener('mouseenter', function () {
      console.log("YEAH")
      if (!sound.paused) {
        sound.pause();
        sound.currentTime = 0;
      }
      sound.play();
    });
  }
})
