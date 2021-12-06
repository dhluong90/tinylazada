import React from 'react'
import {
  CPagination,
  CPaginationItem,
  CTable,
  CTableBody,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
  CTableDataCell,
} from '@coreui/react'
import DataTableList from '../common/data-table-list'

const AllMall = () => {
  const tableHeaders = [
    {
      label: 'id',
      dataColumn: 'id',
    },
    {
      label: 'name',
      dataColumn: 'name',
    },
  ]
  const malls = [
    {
      id: 1,
      name: 'lazada',
    },
    {
      id: 2,
      name: 'RedMall',
    },
  ]
  return (
    <div>
      <DataTableList headers={tableHeaders} dataRows={malls}></DataTableList>
    </div>
  )
}

export default AllMall
