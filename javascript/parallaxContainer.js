document.addEventListener('mousemove', e => {
    let x = e.clientX / window.innerWidth - 0.5;
    let y = e.clientY / window.innerHeight - 0.5;

    if (window.innerWidth >= 600) {
        document.querySelector('.background-image').style.transform = 'translate(' + x * 20 + 'px, ' + y * 20 + 'px)';
    }
});
