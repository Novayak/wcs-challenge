$(document).ready( (function() {

    var $list, $newItemForm;
    $list = $('.member-list');
    $newItemForm = $('.new-member-form');
  
    $newItemForm.on('submit', function(e) {
      e.preventDefault();
      var name = $('input:text').val();
      $list.append('<div class="member-item">' + name + '</div>');
      $('input:text').val('');
    }); 
  
  
  }));