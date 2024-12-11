import React, {useState} from "react";
import axios from "axios";

function Control() {
    // 실제 테이블 데이터 상태
  const [iotData, setIotData] = useState([
    { id: 2, status: "ACTIVE" },
  ]);

  // 임시 변경 상태를 저장
  const [tempStatus, setTempStatus] = useState({});

  // select 변경 핸들러: 임시 상태 업데이트
  const handleStatusChange = (id, newStatus) => {
    setTempStatus((prev) => ({
      ...prev,
      [id]: newStatus,
    }));
  };

  // 확인 버튼 핸들러: 실제 상태 업데이트
  const handleActive = () => {
    const updatedData = iotData.map((item) => ({
      ...item,
      status: tempStatus[item.id] || item.status, // 임시 상태가 있으면 반영, 없으면 기존 상태 유지
    }));
    setIotData(updatedData); // 실제 데이터 상태 업데이트
    setTempStatus({}); // 임시 상태 초기화
    alert("수정되었습니다.");
  };

  return (
    <div style={styles.container}>
      <header style={{ textAlign: "center", marginBottom: "20px" }}>
        <h1 style={styles.title}>IoT 활성 상태 제어</h1>
      </header>
      <table style={styles.table}>
        <thead>
          <tr>
            <th style={styles.th}>IoT 번호</th>
            <th style={styles.th}>IoT 제어 정보</th>
            <th style={styles.th}>상태 변경</th>
          </tr>
        </thead>
        <tbody>
          {iotData.map((item) => (
            <tr key={item.id}>
              <td style={styles.td}>{item.id}</td>
              <td style={styles.td}>{item.status}</td>
              <td style={styles.td}>
                <select
                  value={tempStatus[item.id] || item.status} // 임시 상태가 있으면 사용, 없으면 기존 상태 사용
                  onChange={(e) => handleStatusChange(item.id, e.target.value)}
                >
                  <option value="INACTIVE">INACTIVE</option>
                  <option value="ACTIVE">ACTIVE</option>
                </select>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={handleActive} style={{ ...styles.button, width: "10%" }}>
        확인
      </button>
      <footer
        style={{
          textAlign: "center",
          marginTop: "40px",
          color: "#888",
        }}
      >
        <img src='../ParkingLogo.png'></img>
            <p>
                © 2024 가천대학교 P-실무프로젝트 무한이 주차비서 관리자 대시보드 <br />
                Dev : Team SSHG
            </p>
      </footer>
    </div>
    );
}

const styles = {
    container: { padding: '20px', textAlign: 'center', backgroundColor: '#F9F9F9' },
    title: { marginBottom: '20px' },
    table: {
      width: '100%',
      borderCollapse: 'collapse',
      margin: '0 auto',
      maxWidth: '800px',
    },
    th: {
      border: '1px solid #FFF',
      padding: '8px',
      color: '#FFFFFF',
      backgroundColor: '#014f9e',
      fontWeight: 'bold',
    },
    td: {
      border: '1px solid #ddd',
      padding: '8px',
      textAlign: 'center',
    },
    error: {
      color: 'red',
      fontWeight: 'bold',
    },
    button: {
        padding: '10px 15px',
        fontSize: '16px',
        color: '#fff',
        background: '#00C6FF',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
        margin: '10px'
    },
};

export default Control;