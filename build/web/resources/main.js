/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('#miagiste').on('click', function() { 
        document.getElementById('option_miagiste').style.display = ($(this).is(':checked')) ? "block" : "none";
        document.getElementById('option_entreprise').style.display = ($(this).is(':checked')) ? "none" : "block";
}); 
$('#entreprise').on('click', function() { 
        document.getElementById('option_entreprise').style.display = ($(this).is(':checked')) ? "block" : "none";
        document.getElementById('option_miagiste').style.display = ($(this).is(':checked')) ? "none" : "block";
});
    