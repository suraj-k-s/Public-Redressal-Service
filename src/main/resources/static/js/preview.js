 
          
          $('#file').on('change', function() {
   
              const size =
                 (this.files[0].size / 1024 / 1024).toFixed(2);
   
              if (size > 1 || size < 1) {
                  alert("File size must not exceed 1MB");
              } else {
                  $("#output").html('<b>' +
                     'This file size is: ' + size + " MB" + '</b>');
              }
          });
    