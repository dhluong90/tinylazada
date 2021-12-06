import React from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilBell,
  cilCalculator,
  cilChartPie,
  cilCursor,
  cilDrop,
  cilNotes,
  cilPencil,
  cilPuzzle,
  cilHouse,
  cilSpeedometer,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'

const _nav = [
  {
    component: CNavItem,
    name: 'Dashboard',
    to: '/dashboard',
  },
  {
    component: CNavGroup,
    name: 'Master Data Management',
    items: [
      {
        component: CNavItem,
        name: 'Mall',
        to: '/mall',
        icon: <CIcon icon={cilHouse} customClassName="nav-icon" />,
      },
    ],
  },
]

export default _nav
