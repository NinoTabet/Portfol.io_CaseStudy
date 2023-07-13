function toggleLike(postId) {
  var likeButton = $('#likeButton-' + postId);
  var likesCountElement = $('#likesCount-' + postId);
  var currentLikes = parseInt(likesCountElement.text());

  if (likeButton.hasClass('liked')) {
      // Unlike post
      $.post('/unlike/' + postId, function (likesCount) {
          if (likesCount !== -1) {
              likesCountElement.text(likesCount);
              likeButton.removeClass('liked');
              likeButton.text('Like');
          }
      });
  } else {
      // Like post
      $.post('/like/' + postId, function (likesCount) {
          if (likesCount !== -1) {
              likesCountElement.text(likesCount);
              likeButton.addClass('liked');
              likeButton.text('Unlike');
          }
      });
  }
}
