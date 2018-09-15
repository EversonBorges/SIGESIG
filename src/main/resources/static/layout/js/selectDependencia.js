/*var carsAndModels = {};
carsAndModels['VO'] = ['V70', 'XC60', 'XC90'];
carsAndModels['VW'] = ['Golf', 'Polo', 'Scirocco', 'Touareg'];
carsAndModels['BMW'] = ['M6', 'X5', 'Z3'];


function ChangeCarList() {
    var carList = document.getElementById("car");
    var modelList = document.getElementById("carmodel");
    var selCar = carList.options[carList.selectedIndex].value;
    window.alert(selCar);
    while (modelList.options.length) {
        modelList.remove(0);
    }
    var cars = carsAndModels[selCar];
    if (cars) {
        var i;
        for (i = 0; i < cars.length; i++) {
            var car = new Option(cars[i], i);
            modelList.options.add(car);
        }
    }
} */


$('#location').change(
        function() {
            $.getJSON("http://localhost:8080/chamada/mods/{id}", {
                cityId : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">--alege agentia--</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].nume + '">'
                            + data[i].nume + '</option>';
                }
                html += '</option>';
                $('#agency').html(html);
            });
        });