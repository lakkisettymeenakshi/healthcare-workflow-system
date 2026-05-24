import React, { useEffect, useState } from "react";
import axios from "axios";

function Patients() {

  const [patients, setPatients] = useState([]);

  useEffect(() => {
    loadPatients();
  }, []);

  const loadPatients = async () => {

    try {

      const response = await axios.get(
        "http://localhost:8080/api/patients"
      );

      console.log(response.data);

      setPatients(response.data);

    } catch (error) {

      console.log(error);

    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Healthcare Workflow System</h1>

      {patients.length === 0 ? (
        <p>No Patients Found</p>
      ) : (
        patients.map(patient => (
          <div
            key={patient.id}
            style={{
              border: "1px solid gray",
              padding: "10px",
              marginBottom: "10px"
            }}
          >
            <h3>{patient.name}</h3>
            <p>Age: {patient.age}</p>
            <p>Disease: {patient.disease}</p>
          </div>
        ))
      )}
    </div>
  );
}

export default Patients;