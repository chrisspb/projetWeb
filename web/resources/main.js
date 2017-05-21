/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

$('#miagiste').on('click', function() { 
        document.getElementById('option_miagiste').style.display = ($(this).is(':checked')) ? "block" : "none";
        document.getElementById('option_entreprise').style.display = ($(this).is(':checked')) ? "none" : "block";
}); 
$('#entreprise').on('click', function() { 
        document.getElementById('option_entreprise').style.display = ($(this).is(':checked')) ? "block" : "none";
        document.getElementById('option_miagiste').style.display = ($(this).is(':checked')) ? "none" : "block";
});

$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 80, // Creates a dropdown of 15 years to control year
    format: 'dd/mm/yyyy',
    max: true // for today
  });
    