function toggleLike(postId, userId) {
  var likeButton = $('#likeButton-' + postId);
  var likesCountElement = $('#likesCount-' + postId);
  var currentLikes = parseInt(likesCountElement.text());

  if (likeButton.hasClass('liked')) {
      // Unlike post
      $.ajax({
          url: '/api/posts/' + postId + '/likes',
          type: 'DELETE',
          data: JSON.stringify(userId),
          contentType: 'application/json',
          success: function(response) {
              likesCountElement.text(response.likes);
              likeButton.removeClass('liked');
              likeButton.text('Like');
          }
      });
  } else {
      // Like post
      $.ajax({
          url: '/api/posts/' + postId + '/likes',
          type: 'POST',
          data: JSON.stringify(userId),
          contentType: 'application/json',
          success: function(response) {
              likesCountElement.text(response.likes);
              likeButton.addClass('liked');
              likeButton.text('Unlike');
          }
      });
  }
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");

  $.ajax({
      /* ... */
      beforeSend: function(xhr) {
          xhr.setRequestHeader(header, token);
      }
      /* ... */
  });

}