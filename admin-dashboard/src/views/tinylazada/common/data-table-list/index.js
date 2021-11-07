import React from 'react'
import PropTypes from 'prop-types'
import {
  CTable,
  CTableHead,
  CTableHeaderCell,
  CTableBody,
  CTableRow,
  CPagination,
  CPaginationItem,
} from '@coreui/react'

const DataTableList = (props) => {
  return (
    <div>
      <div className="tableWrapper">
        <CTable striped>
          <CTableHead>
            <CTableRow>
              {props.headers.map((item, key) => {
                const headerLabel = item.label
                return (
                  <CTableHeaderCell scope="col" key={key}>
                    {headerLabel}
                  </CTableHeaderCell>
                )
              })}
            </CTableRow>
          </CTableHead>
          <CTableBody>
            {props.dataRows.map((data, index) => {
              return (
                <CTableRow key={index}>
                  {props.headers.map((item, key) => {
                    const dataValue = data[item.dataColumn]
                    return (
                      <CTableHeaderCell scope="col" key={key}>
                        {dataValue}
                      </CTableHeaderCell>
                    )
                  })}
                </CTableRow>
              )
            })}
          </CTableBody>
        </CTable>
      </div>
      <div className="paginationWraper">
        <CPagination aria-label="Page navigation example" style={{ float: 'right' }}>
          <CPaginationItem aria-label="Previous" disabled>
            <span aria-hidden="true">&laquo;</span>
          </CPaginationItem>
          <CPaginationItem active>1</CPaginationItem>
          <CPaginationItem>2</CPaginationItem>
          <CPaginationItem>3</CPaginationItem>
          <CPaginationItem aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </CPaginationItem>
        </CPagination>
      </div>
    </div>
  )
}

DataTableList.propTypes = {
  headers: PropTypes.arrayOf(
    PropTypes.shape({
      label: PropTypes.string.isRequired,
      dataColumn: PropTypes.string.isRequired,
      pagination: PropTypes.shape({}),
    }),
  ),
  dataRows: PropTypes.arrayOf(PropTypes.object),
}

export default DataTableList
