/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    
    $('#btn-iniciar-sesion').click(function(e){
        e.preventDefault();
        var data = $('#frm-login').serialize();
        $.post("iniciar_sesion", data, function(res, est, jqXHR){
           alert(res);
        });  
       
    });
});

