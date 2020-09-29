import * as React from 'react';
import {DataGrid} from '@material-ui/data-grid';

const columns = [
    {field: 'id', headerName: 'ID', width: 100},
    {field: 'city', headerName: 'City', width: 200} ,
    {field: 'neighborhood', headerName: 'Neighborhood',width: 200},
    {field: 'street', headerName: 'Street',width: 200},
    {field: 'rooms', headerName: 'Rooms', type: 'number',width: 200},
    {field: 'price', headerName: 'Price', type: 'number',width: 200},
];


export default function DataTable(rows) {
    return (
        <div style={{height: 800, width: '100%'}}>
            <DataGrid rows={rows.rows} columns={columns} pageSize={20}/>
        </div>
    );
}