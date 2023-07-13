document.addEventListener("DOMContentLoaded", function() {
  var images = [
    '/Content/2.jpg',
    '/Content/3.jpg',
    '/Content/4.jpg',
    '/Content/5.jpg',
    '/Content/6.jpg',
    '/Content/7.jpg',
    '/Content/8.jpg',
    '/Content/9.jpg',
    '/Content/10.jpg',
    '/Content/1.jpg',
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
