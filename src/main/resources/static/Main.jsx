import React, {useEffect} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import DataTable from "./DataTable";


const useStyles = makeStyles({
    root: {
        flexGrow: 1,
    },
});

export default function Main() {
    const classes = useStyles();
    const [value, setValue] = React.useState(0);
    const [alerts, setAlerts] = React.useState([]);
    const [currentAlert, setCurrentAlert] = React.useState({});

    const handleChange = (event, newValue) => {
        setValue(newValue);
        setCurrentAlert(alerts[newValue]);
    };

    async function fetchData() {
        const res = await fetch("/api/alerts");
        res
            .json()
            .then(res => {
                console.log(res);
                setAlerts(res);
            })
    }

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div>
            <Paper className={classes.root}>
                <Tabs
                    value={value}
                    onChange={handleChange}
                    indicatorColor="primary"
                    textColor="primary"
                    centered
                >
                    {alerts && alerts.map(alert => {
                        return <Tab
                            key={alert.id}
                            label={alert.city + ' ' + alert.neighborhood}
                        />
                    })};
                </Tabs>
            </Paper>

            {currentAlert && currentAlert.houses &&
                <div>
                <h1>Showing results for {currentAlert.city} {currentAlert.neighborhood}{" "}
                    rooms: {currentAlert.roomsFrom}-{currentAlert.roomsTo}{" "}
                    price: {currentAlert.priceFrom}-{currentAlert.priceTo}
                </h1>
                <DataTable rows={currentAlert.houses}/>
                </div>
            }
        </div>
    );
}