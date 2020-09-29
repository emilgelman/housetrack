import * as React from 'react';
import {DataGrid} from '@material-ui/data-grid';

const columns = [
    {field: 'id', headerName: 'ID', width: 100, renderCell: (params) => (
            <u>
                {params.value}
            </u>
        ),
    },
    {field: 'city', headerName: 'City', width: 200} ,
    {field: 'neighborhood', headerName: 'Neighborhood',width: 200},
    {field: 'street', headerName: 'Street',width: 200},
    {field: 'rooms', headerName: 'Rooms', type: 'number',width: 200},
    {field: 'price', headerName: 'Price', type: 'number',width: 200},
    {field: 'sellerType', headerName: 'Seller type', width: 150},
];


export default function DataTable(rows) {

    const handleCellClick = (event) => {
        if (event.field === "id")
        {
            window.open("http://www.yad2.co.il/item/" + event.value, "_blank");
        }
    };

    return (
        <div style={{height: 800, width: '100%'}}>
            <DataGrid rows={rows.rows} columns={columns} pageSize={20} onCellClick={handleCellClick}/>
        </div>
    );
}