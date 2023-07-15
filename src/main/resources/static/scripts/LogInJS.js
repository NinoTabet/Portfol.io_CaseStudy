document.addEventListener("DOMContentLoaded", function() {
  var images = [
    '/content/2.jpg',
    '/content/3.jpg',
    '/content/4.jpg',
    '/content/5.jpg',
    '/content/6.jpg',
    '/content/7.jpg',
    '/content/8.jpg',
    '/content/9.jpg',
    '/content/10.jpg',
    '/content/1.jpg',
    // Add more image URLs as needed
    // needd to make this random from database
  ];

  var currentImageIndex = 0;
  var backgroundImage = document.querySelector(".background-image");

  function changeBackgroundImage() {
    backgroundImage.style.opacity = "0";
    setTimeout(function() {
      backgroundImage.style.backgroundImage = 'url("' + images[currentImageIndex] + '")';
      backgroundImage.style.opacity = "1";
      currentImageIndex = (currentImageIndex + 1) % images.length;
    }, 1000);
  }

  setInterval(changeBackgroundImage, 7000);
});
document.addEventListener("DOMContentLoaded", function() {
  var copyButton = document.getElementById("copyButton");
  var notification = document.getElementById("notification");

  if (copyButton) {
    copyButton.addEventListener("click", function() {
      var buttonText = copyButton.innerText;

      navigator.clipboard.writeText(buttonText)
        .then(function() {
          console.log("Text copied to clipboard: " + buttonText);
          showNotification();
        })
        .catch(function(error) {
          console.error("Error copying text to clipboard: ", error);
        });
    });
  } else {
    console.error("Copy button element not found.");
  }

  function showNotification() {
    notification.classList.add("show");
    setTimeout(function() {
      notification.classList.remove("show");
    }, 3000);
  }
});
