$(function (){

    $('#tblList').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/todos",
            "type": "GET",
            "dataType": "json",
            "contentType": "application/json",
            "dataSrc": ""
        },
        "columns": [
            {"data": "id", "width": "20%"},
            {"data": "todoName","width": "20%"},
            {"data": "endDate", "width": "20%"},
            {"data": "status", "width": "20%"}
        ]
    });

    $("#btnAdd").click(function(){
        $("#divCreateUpdate").modal();
    });

    $("#btnSave").click(function (){
        let params = {
            todoName: $("#txtName").val(),
            endDate : $("#txtEndDate").val(),
            status: $("#ddlStatus").val(),
        };

        $.ajax({
                url: "/todos",
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(params),
                success: function(d){
                    alert("Record saved.");
                    $("#divCreateUpdate").modal("hide");
                    $('#tblList').DataTable().ajax.reload();
                }
        });
    });
});